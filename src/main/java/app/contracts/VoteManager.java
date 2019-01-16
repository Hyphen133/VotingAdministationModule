package app.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
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
    private static final String BINARY = "60c0604052600f60808190527f54554c20766f74652073797374656d000000000000000000000000000000000060a09081526200004091600091906200039d565b503480156200004e57600080fd5b5060018054600160a060020a0319163317905560408051600280825260608281019093528160200160208202803883390190505090507f4100000000000000000000000000000000000000000000000000000000000000816000815181101515620000b557fe5b6020908102909101015280517f42000000000000000000000000000000000000000000000000000000000000009082906001908110620000f157fe5b6020908102909101015260408051600580825260c08201909252606091816020016020820280388339019050509050620335078160008151811015156200013457fe5b6020908102909101015260015b60058110156200016e578082828151811015156200015b57fe5b6020908102909101015260010162000141565b50620001a57f53757065720000000000000000000000000000000000000000000000000000008383640100000000620001ad810204565b505062000442565b60408051606081018252848152600160208201818152855193830193845260028054928301808255600082815294517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace600586029081019190915592517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf8401805460ff191691151591909117905594517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ad090920191909155805490919081106200027457fe5b60009182526020822060059091020191505b8451811015620002e15760408051908101604052808683815181101515620002aa57fe5b6020908102909101810151825260009181018290528382526003850181526040909120825181559101516001918201550162000286565b5060005b83518110156200036857604080518082019091526001815260006020820181905285516004850191908790859081106200031b57fe5b602090810290910181015182528181019290925260400160002082518154939092015115156101000261ff001992151560ff199094169390931791909116919091179055600101620002e5565b50604051829086907f218de4eb5b4beb7ddff8b5909f0d3300ec7ef5439ead74a8e3381503c260938190600090a35050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620003e057805160ff191683800117855562000410565b8280016001018555821562000410579182015b8281111562000410578251825591602001919060010190620003f3565b506200041e92915062000422565b5090565b6200043f91905b808211156200041e576000815560010162000429565b90565b6110f580620004526000396000f3fe608060405234801561001057600080fd5b50600436106100d1576000357c0100000000000000000000000000000000000000000000000000000000900480638a6655d61161008e5780638a6655d61461028b5780638da5cb5b146102b4578063a44b7f56146102e5578063aa55eb301461038b578063eb87c6dc146104b9578063f3f044931461059f576100d1565b806307dd2e4b146100d657806309578a2e14610153578063396aabeb146101c057806348fcc144146101f55780634bd46448146102145780635c632b3814610250575b600080fd5b6100de610655565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610118578181015183820152602001610100565b50505050905090810190601f1680156101455780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101706004803603602081101561016957600080fd5b50356106e3565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101ac578181015183820152602001610194565b505050509050019250505060405180910390f35b6101e3600480360360408110156101d657600080fd5b5080359060200135610794565b60408051918252519081900360200190f35b6102126004803603602081101561020b57600080fd5b50356107ce565b005b6102376004803603604081101561022a57600080fd5b50803590602001356108b3565b6040805192835260208301919091528051918290030190f35b61026d6004803603602081101561026657600080fd5b5035610924565b60408051938452911515602084015282820152519081900360600190f35b610212600480360360608110156102a157600080fd5b508035906020810135906040013561095b565b6102bc610b49565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b610212600480360360208110156102fb57600080fd5b81019060208101813564010000000081111561031657600080fd5b82018360208201111561032857600080fd5b8035906020019184600183028401116401000000008311171561034a57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610b65945050505050565b610212600480360360608110156103a157600080fd5b813591908101906040810160208201356401000000008111156103c357600080fd5b8201836020820111156103d557600080fd5b803590602001918460208302840111640100000000831117156103f757600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929594936020810193503591505064010000000081111561044757600080fd5b82018360208201111561045957600080fd5b8035906020019184602083028401116401000000008311171561047b57600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929550610b7c945050505050565b6104c1610d65565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156105095781810151838201526020016104f1565b50505050905001848103835286818151815260200191508051906020019060200280838360005b83811015610548578181015183820152602001610530565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561058757818101518382015260200161056f565b50505050905001965050505050505060405180910390f35b6105bc600480360360208110156105b557600080fd5b5035610edc565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b838110156106005781810151838201526020016105e8565b50505050905001838103825284818151815260200191508051906020019060200280838360005b8381101561063f578181015183820152602001610627565b5050505090500194505050505060405180910390f35b6000805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156106db5780601f106106b0576101008083540402835291602001916106db565b820191906000526020600020905b8154815290600101906020018083116106be57829003601f168201915b505050505081565b6060806002838154811015156106f557fe5b906000526020600020906005020160020154604051908082528060200260200182016040528015610730578160200160208202803883390190505b50905060005b815181101561078d57600280548590811061074d57fe5b6000918252602080832084845260036005909302019190910190526040902054825183908390811061077b57fe5b60209081029091010152600101610736565b5092915050565b60006002838154811015156107a557fe5b600091825260208083209483526003600590920290940101909252506040902060010154919050565b60015473ffffffffffffffffffffffffffffffffffffffff16331461085457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f4f776e65722d6f6e6c79206d6574686f642e0000000000000000000000000000604482015290519081900360640190fd5b600060028281548110151561086557fe5b60009182526020822060059190910201600101805460ff19169215159290921790915560405182917f22bd719ab927d287a1348ad43a9f33df8864f883e8e6c9d80d25b498f555668891a250565b6000806002848154811015156108c557fe5b600091825260208083208684526003600590930201919091019052604090205460028054869081106108f357fe5b9060005260206000209060050201600301600085815260200190815260200160002060010154915091509250929050565b600280548290811061093257fe5b600091825260209091206005909102018054600182015460029092015490925060ff9091169083565b600280548490811061096957fe5b600091825260208083208584526004600590930201919091019052604090205460ff1615156109f957604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601760248201527f5468657265206973206e6f207375636820766f7465722e000000000000000000604482015290519081900360640190fd5b6002805484908110610a0757fe5b6000918252602080832085845260059290920290910160040190526040902054610100900460ff1615610a9b57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601d60248201527f5468697320766f7465722068617320616c726561647920766f7465642e000000604482015290519081900360640190fd5b6001600284815481101515610aac57fe5b6000918252602080832086845260046005909302019190910190526040902080549115156101000261ff00199092169190911790556002805484908110610aef57fe5b600091825260208083208484526003600590930201919091019052604080822060019081018054909101905551829185917f84a5508ca0d85b42a876e75a9126f3ae7b43617ce60b170bf8805d34630bc6549190a3505050565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b8051610b7890600090602084019061102e565b5050565b60408051606081018252848152600160208201818152855193830193845260028054928301808255600082815294517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace600586029081019190915592517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf8401805460ff191691151591909117905594517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ad09092019190915580549091908110610c4257fe5b60009182526020822060059091020191505b8451811015610cac5760408051908101604052808683815181101515610c7657fe5b60209081029091018101518252600091810182905283825260038501815260409091208251815591015160019182015501610c54565b5060005b8351811015610d305760408051808201909152600181526000602082018190528551600485019190879085908110610ce457fe5b602090810290910181015182528181019290925260400160002082518154939092015115156101000261ff001992151560ff199094169390931791909116919091179055600101610cb0565b50604051829086907f218de4eb5b4beb7ddff8b5909f0d3300ec7ef5439ead74a8e3381503c260938190600090a35050505050565b606080606080600280549050604051908082528060200260200182016040528015610d9a578160200160208202803883390190505b5090506060600280549050604051908082528060200260200182016040528015610dce578160200160208202803883390190505b5090506060600280549050604051908082528060200260200182016040528015610e02578160200160208202803883390190505b50905060005b600254811015610ecf576002805482908110610e2057fe5b6000918252602090912060016005909202010154845160ff90911690859083908110610e4857fe5b9115156020928302909101909101526002805482908110610e6557fe5b9060005260206000209060050201600201548382815181101515610e8557fe5b602090810290910101526002805482908110610e9d57fe5b9060005260206000209060050201600001548282815181101515610ebd57fe5b60209081029091010152600101610e08565b5091945092509050909192565b6060806060600284815481101515610ef057fe5b906000526020600020906005020160020154604051908082528060200260200182016040528015610f2b578160200160208202803883390190505b5090506060600285815481101515610f3f57fe5b906000526020600020906005020160020154604051908082528060200260200182016040528015610f7a578160200160208202803883390190505b50905060005b8251811015611023576002805487908110610f9757fe5b60009182526020808320848452600360059093020191909101905260409020548351849083908110610fc557fe5b602090810290910101526002805487908110610fdd57fe5b9060005260206000209060050201600301600082815260200190815260200160002060010154828281518110151561101157fe5b60209081029091010152600101610f80565b509092509050915091565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061106f57805160ff191683800117855561109c565b8280016001018555821561109c579182015b8281111561109c578251825591602001919060010190611081565b506110a89291506110ac565b5090565b6110c691905b808211156110a857600081556001016110b2565b9056fea165627a7a72305820cf1a8031179b088c6afa466a483c074ee213fc638df945f10f6ebd76b6e90cd20029";

    public static final String FUNC_SYSTEMNAME = "systemName";

    public static final String FUNC_GETCANDIDATENAMESFORBALLOT = "getCandidateNamesForBallot";

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

//    public static final Event BALLOTCREATION_EVENT = new Event("BallotCreation",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}));
//    ;

//    public static final Event BALLOTEND_EVENT = new Event("BallotEnd",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
//    ;
//
//    public static final Event VOTED_EVENT = new Event("Voted",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>(true) {}));
//    ;

    @Deprecated
    protected VoteManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

//    protected VoteManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);


    @Deprecated
    protected VoteManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VoteManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<Tuple3<byte[], Boolean, BigInteger>> ballots(BigInteger param0) {
        final Function function = new Function(FUNC_BALLOTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<byte[], Boolean, BigInteger>>(
                new Callable<Tuple3<byte[], Boolean, BigInteger>>() {
                    @Override
                    public Tuple3<byte[], Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], Boolean, BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
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

    public RemoteCall<TransactionReceipt> createBallot(byte[] name, List<byte[]> candidateNames, List<BigInteger> voters) {
        final Function function = new Function(
                FUNC_CREATEBALLOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(voters, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<List<Boolean>, List<BigInteger>, List<byte[]>>> getBallots() {
        final Function function = new Function(FUNC_GETBALLOTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bool>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteCall<Tuple3<List<Boolean>, List<BigInteger>, List<byte[]>>>(
                new Callable<Tuple3<List<Boolean>, List<BigInteger>, List<byte[]>>>() {
                    @Override
                    public Tuple3<List<Boolean>, List<BigInteger>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<Boolean>, List<BigInteger>, List<byte[]>>(
                                convertToNative((List<Bool>) results.get(0).getValue()), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()));
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

//    public List<BallotCreationEventResponse> getBallotCreationEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BALLOTCREATION_EVENT, transactionReceipt);
//        ArrayList<BallotCreationEventResponse> responses = new ArrayList<BallotCreationEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            BallotCreationEventResponse typedResponse = new BallotCreationEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<BallotCreationEventResponse> ballotCreationEventFlowable(EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, BallotCreationEventResponse>() {
//            @Override
//            public BallotCreationEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BALLOTCREATION_EVENT, log);
//                BallotCreationEventResponse typedResponse = new BallotCreationEventResponse();
//                typedResponse.log = log;
//                typedResponse.name = (byte[]) eventValues.getIndexedValues().get(0).getValue();
//                typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
//                return typedResponse;
//            }
//        });
//    }

//    public Flowable<BallotCreationEventResponse> ballotCreationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(BALLOTCREATION_EVENT));
//        return ballotCreationEventFlowable(filter);
//    }

//    public List<BallotEndEventResponse> getBallotEndEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BALLOTEND_EVENT, transactionReceipt);
//        ArrayList<BallotEndEventResponse> responses = new ArrayList<BallotEndEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            BallotEndEventResponse typedResponse = new BallotEndEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<BallotEndEventResponse> ballotEndEventFlowable(EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, BallotEndEventResponse>() {
//            @Override
//            public BallotEndEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BALLOTEND_EVENT, log);
//                BallotEndEventResponse typedResponse = new BallotEndEventResponse();
//                typedResponse.log = log;
//                typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
//                return typedResponse;
//            }
//        });
//    }
//
//    public Flowable<BallotEndEventResponse> ballotEndEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(BALLOTEND_EVENT));
//        return ballotEndEventFlowable(filter);
//    }
//
//    public List<VotedEventResponse> getVotedEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VOTED_EVENT, transactionReceipt);
//        ArrayList<VotedEventResponse> responses = new ArrayList<VotedEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            VotedEventResponse typedResponse = new VotedEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse.candidate = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<VotedEventResponse> votedEventFlowable(EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, VotedEventResponse>() {
//            @Override
//            public VotedEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VOTED_EVENT, log);
//                VotedEventResponse typedResponse = new VotedEventResponse();
//                typedResponse.log = log;
//                typedResponse.ballot = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
//                typedResponse.candidate = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
//                return typedResponse;
//            }
//        });
//    }
//
//    public Flowable<VotedEventResponse> votedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(VOTED_EVENT));
//        return votedEventFlowable(filter);
//    }

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

    public static class BallotCreationEventResponse {
        public Log log;

        public byte[] name;

        public BigInteger ballot;
    }

    public static class BallotEndEventResponse {
        public Log log;

        public BigInteger ballot;
    }

    public static class VotedEventResponse {
        public Log log;

        public BigInteger ballot;

        public BigInteger candidate;
    }
}
