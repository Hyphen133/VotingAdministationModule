package app.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class VoteManager extends Contract {
    private static final String BINARY = "60c0604052600f60808190527f54554c20766f74652073797374656d000000000000000000000000000000000060a09081526200004091600091906200030e565b5060006002553480156200005357600080fd5b5060018054600160a060020a0319163317905560408051600280825260608281019093528160200160208202803883390190505090507f4100000000000000000000000000000000000000000000000000000000000000816000815181101515620000ba57fe5b6020908102909101015280517f42000000000000000000000000000000000000000000000000000000000000009082906001908110620000f657fe5b60209081029091010152604080516064808252610ca08201909252606091816020016020820280388339019050509050620335078160008151811015156200013a57fe5b6020908102909101015260005b606481101562000174578082828151811015156200016157fe5b6020908102909101015260010162000147565b50604080518082019091526001808252600260208301908152600380549283018155600081815293517fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b6004909402938401805460ff191691151591909117905590517fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85c90920191909155805460001981019081106200021057fe5b60009182526020822060049091020191505b60028110156200027d57604080519081016040528085838151811015156200024657fe5b6020908102909101810151825260009181018290528382526002850181526040909120825181559101516001918201550162000222565b5060005b8251811015620003045760408051808201909152600181526000602082018190528451600385019190869085908110620002b757fe5b602090810290910181015182528181019290925260400160002082518154939092015115156101000261ff001992151560ff19909416939093179190911691909117905560010162000281565b50505050620003b3565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200035157805160ff191683800117855562000381565b8280016001018555821562000381579182015b828111156200038157825182559160200191906001019062000364565b506200038f92915062000393565b5090565b620003b091905b808211156200038f57600081556001016200039a565b90565b610f8680620003c36000396000f3fe6080604052600436106100be577c0100000000000000000000000000000000000000000000000000000000600035046307dd2e4b81146100c357806309578a2e1461014d57806314b9f2e3146101c7578063396aabeb146101ee57806348fcc1441461021e5780634bd464481461024a5780635c632b38146102935780638a6655d6146102d85780638da5cb5b1461030e578063a44b7f561461034c578063d826c476146103ff578063eb87c6dc14610533578063f3f04493146105e1575b600080fd5b3480156100cf57600080fd5b506100d861060b565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101125781810151838201526020016100fa565b50505050905090810190601f16801561013f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561015957600080fd5b506101776004803603602081101561017057600080fd5b5035610699565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101b357818101518382015260200161019b565b505050509050019250505060405180910390f35b3480156101d357600080fd5b506101dc61074a565b60408051918252519081900360200190f35b3480156101fa57600080fd5b506101dc6004803603604081101561021157600080fd5b5080359060200135610750565b34801561022a57600080fd5b506102486004803603602081101561024157600080fd5b503561078a565b005b34801561025657600080fd5b5061027a6004803603604081101561026d57600080fd5b5080359060200135610843565b6040805192835260208301919091528051918290030190f35b34801561029f57600080fd5b506102bd600480360360208110156102b657600080fd5b50356108b4565b60408051921515835260208301919091528051918290030190f35b3480156102e457600080fd5b50610248600480360360608110156102fb57600080fd5b50803590602081013590604001356108e4565b34801561031a57600080fd5b50610323610aa5565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b34801561035857600080fd5b506102486004803603602081101561036f57600080fd5b81019060208101813564010000000081111561038a57600080fd5b82018360208201111561039c57600080fd5b803590602001918460018302840111640100000000831117156103be57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610ac1945050505050565b34801561040b57600080fd5b506102486004803603604081101561042257600080fd5b81019060208101813564010000000081111561043d57600080fd5b82018360208201111561044f57600080fd5b8035906020019184602083028401116401000000008311171561047157600080fd5b91908080602002602001604051908101604052809392919081815260200183836020028082843760009201919091525092959493602081019350359150506401000000008111156104c157600080fd5b8201836020820111156104d357600080fd5b803590602001918460208302840111640100000000831117156104f557600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929550610ad8945050505050565b34801561053f57600080fd5b50610548610c69565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b8381101561058c578181015183820152602001610574565b50505050905001838103825284818151815260200191508051906020019060200280838360005b838110156105cb5781810151838201526020016105b3565b5050505090500194505050505060405180910390f35b3480156105ed57600080fd5b506105486004803603602081101561060457600080fd5b5035610d6d565b6000805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106915780601f1061066657610100808354040283529160200191610691565b820191906000526020600020905b81548152906001019060200180831161067457829003601f168201915b505050505081565b6060806003838154811015156106ab57fe5b9060005260206000209060040201600101546040519080825280602002602001820160405280156106e6578160200160208202803883390190505b50905060005b815181101561074357600380548590811061070357fe5b6000918252602080832084845260026004909302019190910190526040902054825183908390811061073157fe5b602090810290910101526001016106ec565b5092915050565b60025481565b600060038381548110151561076157fe5b600091825260208083209483526002600490920290940101909252506040902060010154919050565b60015473ffffffffffffffffffffffffffffffffffffffff16331461081057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f4f776e65722d6f6e6c79206d6574686f642e0000000000000000000000000000604482015290519081900360640190fd5b600060038281548110151561082157fe5b60009182526020909120600490910201805460ff191691151591909117905550565b60008060038481548110151561085557fe5b6000918252602080832086845260026004909302019190910190526040902054600380548690811061088357fe5b9060005260206000209060040201600201600085815260200190815260200160002060010154915091509250929050565b60038054829081106108c257fe5b60009182526020909120600490910201805460019091015460ff909116915082565b60038054849081106108f257fe5b600091825260208083208584526003600490930201919091019052604090205460ff16151561098257604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f5468657265206973206e6f207375636820766f7465722e000000000000000000604482015290519081900360640190fd5b600380548490811061099057fe5b6000918252602080832085845260049290920290910160030190526040902054610100900460ff1615610a2457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601d60248201527f5468697320766f7465722068617320616c726561647920766f7465642e000000604482015290519081900360640190fd5b6001600384815481101515610a3557fe5b60009182526020808320868452600360049093020182019052604090912080549215156101000261ff001990931692909217909155805484908110610a7657fe5b600091825260208083209383526002600490920290930101909152604090206001908101805490910190555050565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b8051610ad4906000906020840190610ebf565b5050565b60408051808201909152600180825283516020830190815260038054928301808255600082815294517fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b60048602908101805460ff19169215159290921790915592517fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85c90930192909255805491939290918110610b7257fe5b60009182526020822060049091020191505b8451811015610bdc5760408051908101604052808683815181101515610ba657fe5b60209081029091018101518252600091810182905283825260028501815260409091208251815591015160019182015501610b84565b5060005b8351811015610c605760408051808201909152600181526000602082018190528551600385019190879085908110610c1457fe5b602090810290910181015182528181019290925260400160002082518154939092015115156101000261ff001992151560ff199094169390931791909116919091179055600101610be0565b50506002555050565b6060806060600380549050604051908082528060200260200182016040528015610c9d578160200160208202803883390190505b5090506060600380549050604051908082528060200260200182016040528015610cd1578160200160208202803883390190505b50905060005b600354811015610d63576003805482908110610cef57fe5b6000918252602090912060049091020154835160ff90911690849083908110610d1457fe5b9115156020928302909101909101526003805482908110610d3157fe5b9060005260206000209060040201600101548282815181101515610d5157fe5b60209081029091010152600101610cd7565b5090925090509091565b6060806060600384815481101515610d8157fe5b906000526020600020906004020160010154604051908082528060200260200182016040528015610dbc578160200160208202803883390190505b5090506060600385815481101515610dd057fe5b906000526020600020906004020160010154604051908082528060200260200182016040528015610e0b578160200160208202803883390190505b50905060005b8251811015610eb4576003805487908110610e2857fe5b60009182526020808320848452600260049093020191909101905260409020548351849083908110610e5657fe5b602090810290910101526003805487908110610e6e57fe5b90600052602060002090600402016002016000828152602001908152602001600020600101548282815181101515610ea257fe5b60209081029091010152600101610e11565b509092509050915091565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610f0057805160ff1916838001178555610f2d565b82800160010185558215610f2d579182015b82811115610f2d578251825591602001919060010190610f12565b50610f39929150610f3d565b5090565b610f5791905b80821115610f395760008155600101610f43565b9056fea165627a7a723058201a5860a96a47523d3fd034bdf7df35fb108805a45e8feb8ea56e9cbe748dfd7c0029";

    public static final String FUNC_SYSTEMNAME = "systemName";

    public static final String FUNC_GETCANDIDATENAMESFORBALLOT = "getCandidateNamesForBallot";

    public static final String FUNC_LASTBALLOTINDEX = "lastBallotIndex";

    public static final String FUNC_GETCANDIDATEVOTECOUNT = "getCandidateVoteCount";

    public static final String FUNC_ENDBALLOT = "endBallot";

    public static final String FUNC_GETCANDIDATE = "getCandidate";

    public static final String FUNC_BALLOTS = "ballots";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SETSYSTEMNAME = "setSystemName";

    public static final String FUNC_CREATEBALLOT = "createBallot";

    public static final String FUNC_GETBALLOTS = "getBallots";

    public static final String FUNC_GETCANDIDATSFORBALLOT = "getCandidatsForBallot";

    @Deprecated
    public VoteManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

//    protected VoteManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
//    }

    @Deprecated
    public VoteManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public VoteManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> systemName() {
        final Function function = new Function(FUNC_SYSTEMNAME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getCandidateNamesForBallot(BigInteger ballotIndex) {
        final Function function = new Function(FUNC_GETCANDIDATENAMESFORBALLOT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ballotIndex)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> lastBallotIndex() {
        final Function function = new Function(FUNC_LASTBALLOTINDEX,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getCandidateVoteCount(BigInteger ballot, BigInteger candidate) {
        final Function function = new Function(FUNC_GETCANDIDATEVOTECOUNT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ballot),
                new org.web3j.abi.datatypes.generated.Uint256(candidate)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> endBallot(BigInteger id) {
        final Function function = new Function(
                FUNC_ENDBALLOT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<byte[], BigInteger>> getCandidate(BigInteger ballot, BigInteger candidate) {
        final Function function = new Function(FUNC_GETCANDIDATE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ballot),
                new org.web3j.abi.datatypes.generated.Uint256(candidate)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<byte[], BigInteger>>(
                new Callable<Tuple2<byte[], BigInteger>>() {
                    @Override
                    public Tuple2<byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<Boolean, BigInteger>> ballots(BigInteger param0) {
        final Function function = new Function(FUNC_BALLOTS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<Boolean, BigInteger>>(
            new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger ballotId, BigInteger voterId, BigInteger candidateId) {
        final Function function = new Function(
                FUNC_VOTE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ballotId),
                new org.web3j.abi.datatypes.generated.Uint256(voterId),
                new org.web3j.abi.datatypes.generated.Uint256(candidateId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setSystemName(String x) {
        final Function function = new Function(
                FUNC_SETSYSTEMNAME,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(x)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createBallot(List<byte[]> candidateNames, List<BigInteger> voters) {
        final Function function = new Function(
                FUNC_CREATEBALLOT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class)),
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(voters, org.web3j.abi.datatypes.generated.Uint256.class))),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<List<Boolean>, List<BigInteger>>> getBallots() {
        final Function function = new Function(FUNC_GETBALLOTS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bool>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple2<List<Boolean>, List<BigInteger>>>(
                new Callable<Tuple2<List<Boolean>, List<BigInteger>>>() {
                    @Override
                    public Tuple2<List<Boolean>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<Boolean>, List<BigInteger>>(
                                convertToNative((List<Bool>) results.get(0).getValue()),
                                convertToNative((List<Uint256>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<Tuple2<List<byte[]>, List<BigInteger>>> getCandidatsForBallot(BigInteger ballotIndex) {
        final Function function = new Function(FUNC_GETCANDIDATSFORBALLOT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ballotIndex)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple2<List<byte[]>, List<BigInteger>>>(
                new Callable<Tuple2<List<byte[]>, List<BigInteger>>>() {
                    @Override
                    public Tuple2<List<byte[]>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<byte[]>, List<BigInteger>>(
                                convertToNative((List<Bytes32>) results.get(0).getValue()),
                                convertToNative((List<Uint256>) results.get(1).getValue()));
                    }
                });
    }

    @Deprecated
    public static VoteManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VoteManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VoteManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VoteManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

//    public static VoteManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return new VoteManager(contractAddress, web3j, credentials, contractGasProvider);
//    }

    public static VoteManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VoteManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

//    public static RemoteCall<VoteManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(VoteManager.class, web3j, credentials, contractGasProvider, BINARY, "");
//    }
//
//    public static RemoteCall<VoteManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(VoteManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
//    }

    @Deprecated
    public static RemoteCall<VoteManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VoteManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VoteManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VoteManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
